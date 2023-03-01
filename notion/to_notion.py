import os
import requests
import json
from bs4 import BeautifulSoup
import markdown2

# Constants
NOTION_API_KEY=os.environ['NOTION_API_KEY']
NOTION_DATABASE_ID=os.environ['NOTION_DATABASE_ID']

# Helper functions

# 로마 숫자를 아라비아 숫자로 변환
def roman_to_number(roman):
    rdict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    nv = roman[0]
    number = rdict[nv]
    for i in range(1, len(roman)):
        bv = nv
        nv = roman[i]
        if rdict[bv] >= rdict[nv]:
            number += rdict[nv]
        else:
            number += rdict[nv] - 2 * rdict[bv]
    return number

# Solved.ac 사이트의 문제 난이도 아이콘 URL 반환
def get_icon_url(teir, grade):
    TIER_DICT = {'Bronze': 0, 'Silver': 1, 'Gold': 2,
                 'Platinum': 3, 'Diamond': 4, 'Ruby': 5}
    teir_score = TIER_DICT[teir] * 5 - roman_to_number(grade) + 6
    return f'https://static.solved.ac/tier_small/{teir_score}.svg'


# Markdown 파일과 답안 파일에서 필요한 정보를 추출하여 Notion 페이지 생성에 필요한 JSON 형식으로 반환
def parse_problem_details(markdown_file, answer_file):
    with open(markdown_file, 'r', encoding='utf8') as f:
        markdown_text = f.read()
        html = markdown2.markdown(markdown_text)

    with open(answer_file, 'r', encoding='utf8') as f:
        answer = f.read()

    soup = BeautifulSoup(html, 'html.parser')
    teir, title = soup.find('h1').get_text().replace('[', '').split(']')
    teir, grade = teir.split()
    link = soup.find('a').attrs['href']
    icon = get_icon_url(teir, grade)

    p = soup.find_all('p', limit=3)
    memory, time = map(lambda x: x.split(': ')[
                       1], p[1].get_text().replace('[', '').split(', '))
    category = [{"name": c} for c in p[2].get_text().split(', ')]

    LANGUAGE_DICT = {'py': 'python', 'java': 'java'}
    language = LANGUAGE_DICT[os.path.splitext(answer_file)[1][1:]]

    return {
        'title': title,
        'link': link,
        'icon': icon,
        'teir': teir,
        'grade': grade,
        'category': category,
        'memory': memory,
        'time': time,
        'language': language,
        'answer': answer
    }


def create_database_page(data):
    with open('notion/template.json', 'r', encoding='UTF-8') as json_file:
        json_data = json.load(json_file)

    json_data['parent']['database_id'] = NOTION_DATABASE_ID

    # Set the page properties
    json_data['properties']['Title']['title'] = [
        {'text': {'content': data['title']}}]
    json_data['properties']['URL']['url'] = data['link']
    json_data['properties']['Tier']['select']['name'] = data['teir']
    json_data['properties']['Grade']['select']['name'] = data['grade']
    json_data['properties']['Category']['multi_select'] = data['category']
    json_data['icon']['external']['url'] = data['icon']

    # Set the code block
    for i in range(0, len(data['answer']), 2000):
        json_data['children'][3]['code']['rich_text'].append({
            'type': 'text',
            'text': {'content': data['answer'][i:i+2000]}
        })
    json_data['children'][3]['code']['language'] = data['language']

    # Set the memory and time table
    json_data['children'][1]["table"]['children'][1]['table_row']['cells'][0][0]['text']['content'] = data['memory']
    json_data['children'][1]["table"]['children'][1]['table_row']['cells'][1][0]['text']['content'] = data['time']
    return json_data


def read_problems_file():
    with open("notion/problems.json", 'r', encoding="UTF-8") as problems_file:
        problems = json.load(problems_file)
        sloved = problems['problems']
    return sloved, problems


def write_problems_file(problems):
    with open("notion/problems.json", 'w', encoding="UTF-8") as f:
        f.write(json.dumps(problems, ensure_ascii=False))


def create_pages():
    headers = {
    "Authorization": "Bearer " + NOTION_API_KEY,
    "Content-Type": "application/json",
    "Notion-Version": "2022-06-28"
}

    solved, problems = read_problems_file()

    for (root, directories, files) in os.walk("백준"):
        for d in directories:
            d_path = os.path.join(root, d)
            if d_path not in solved:
                readme, answer = "", ""
                for i in os.listdir(d_path):
                    if i.endswith('.md'):
                        readme = os.path.join(d_path, i)
                    elif i.endswith('.py') or i.endswith('.java'):
                        answer = os.path.join(d_path, i)
                
                if not readme or not answer:
                    continue
                
                # parse problem details
                data = parse_problem_details(readme, answer)
                
                # create Notion page
                json_data = json.dumps(create_database_page(data))
                
                # add page to the database
                url = "https://api.notion.com/v1/pages"
                response = requests.post(url=url, headers=headers, data=json_data)
                print(response.status_code)
                
                # update problems file
                solved.append(d_path)
                problems['problems'] = solved
                write_problems_file(problems)
                

create_pages()