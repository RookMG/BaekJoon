import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public class Person{
        int age, index;
        String name;
        public Person(int age, int index, String name){
            this.age = age;
            this.index = index;
            this.name = name;
        }
        public int getAge(){
            return this.age;
        }
        public int getIndex(){
            return this.index;
        }
        public String getName(){
            return this.name;
        }
        public String toString(){
            return this.age + " " + this.name + "\n";
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            persons[i] = new Person(Integer.parseInt(st.nextToken()),i,st.nextToken());
        }
        Arrays.sort(persons,(e1,e2) ->{
            if(e1.getAge()==e2.getAge()){
                return e1.getIndex()-e2.getIndex();
            }else{
                return e1.getAge()-e2.getAge();
            }
        });
        for(int i=0;i<n;i++){
            sb.append(persons[i]);
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}