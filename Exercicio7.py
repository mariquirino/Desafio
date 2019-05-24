def exercicio7():
    node = Node("c")
    node2 = Node("a")
    node3 = Node("e")
    node4 = Node("h")

    node5 = Node("j")
    node6 = Node("b")

    node7 = Node("d")
    node8 = Node("f")

    node.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    node5.next = node6

    node7.next = node8
    node8.next = node5

    qtd = count(node)
    qtd2 = count(node7)
    header = node
    header2 = node7
    if qtd > qtd2:
        for i in range(0, qtd - qtd2):
            header = header.next

    elif qtd2 > qtd:
        for i in range(0, qtd2 - qtd):
            header2 = header2.next

    while header:
        if header.data == header2.data:
            print(header.data)
            break
        header = header.next
        header2 = header2.next


def count(node):
    qtd = 0
    prox = node
    while prox:
        prox = prox.next
        qtd += 1
    return qtd


class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None
