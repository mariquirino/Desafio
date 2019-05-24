class Node:
    def __init__(self, email=None, body=None):
        self.email = email
        self.body = body
        self.next = None


def exercicio5():
    # Inicialzando a linkedList
    node = Node("a@", "Hello")
    node2 = Node("b@", "Hello2")
    node3 = Node("a@", "Hello")
    node4 = Node("c@", "Asd")
    node5 = Node("d@", "qwe")
    node6 = Node("e@", "zxc")
    # node7 = Node(8)
    node.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    # node6.next = node7

    # Fazendo o Merge Sort
    header = sort(node)

    # Removendo repetidos
    i = header.next
    ant = header
    while i:
        if i.body == ant.body and i.email == ant.email:
            ant.next = i.next
            i.next = None
        i = i.next
        ant = ant.next

    while header:
        print("Email: " + header.email + " Body: " + header.body)
        header = header.next


def sort(begin):
    if not begin or not begin.next:
        return begin
    nodeMidlle = findMidlle(begin)

    headerRight = nodeMidlle.next
    nodeMidlle.next = None
    nodeLeft = sort(begin)

    nodeRight = sort(headerRight)
    return mergeLists(nodeLeft, nodeRight)


def findMidlle(header):
    nodemidle = header
    header = header.next
    while header.next:
        # if header.next:
        header = header.next
        if header.next:
            header = header.next
        # header = header.next
        nodemidle = nodemidle.next
    return nodemidle


def mergeLists(head1, head2):
    # create a temp node NULL
    temp = None

    # List1 is empty then return List2
    if head1 is None:
        return head2

    # if List2 is empty then return List1
    if head2 is None:
        return head1

    # If List1's data is smaller or
    # equal to List2's data
    if head1.body <= head2.body:

        # assign temp to List1's data
        temp = head1

        # Again check List1's data is smaller or equal List2's
        # data and call mergeLists function.
        temp.next = mergeLists(head1.next, head2)

    else:
        # If List2's data is greater than or equal List1's
        # data assign temp to head2
        temp = head2

        # Again check List2's data is greater or equal List's
        # data and call mergeLists function.
        temp.next = mergeLists(head1, head2.next)

    # return the temp list.
    return temp


if __name__ == "__main__":
    exercicio5()
