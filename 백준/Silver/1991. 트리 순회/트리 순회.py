class Node:
    def __init__(self,d):
        self.data = d
        self.left = None
        self.right = None
    def __str__(self):
        return self.data
    def addLeft(self,node):
        self.left = node
    def addRight(self,node):
        self.right = node
    def order1(self):
        print(self,end='')
        if self.left!=None:
            self.left.order1()
        if self.right!=None:
            self.right.order1()
    def order2(self):
        if self.left!=None:
            self.left.order2()
        print(self,end='')
        if self.right!=None:
            self.right.order2()
    def order3(self):
        if self.left!=None:
            self.left.order3()
        if self.right!=None:
            self.right.order3()
        print(self,end='')
n = int(input())
tree = []
for i in range(n):
    tree.append(Node(chr(ord('A')+i)))
for i in range(n):
    node, left, right = map(str,input().split())
    if left!='.':
        tree[ord(node)-ord('A')].addLeft(tree[ord(left)-ord('A')])
    if right!='.':
        tree[ord(node)-ord('A')].addRight(tree[ord(right)-ord('A')])
tree[0].order1()
print()
tree[0].order2()
print()
tree[0].order3()
print()