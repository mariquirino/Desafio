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
    # node7 = Node("other@", "zxc")
    node.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    # node6.next = node7

    # Start Merge Sort
    header = sort(node)

    # Remove repeated
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
        header = header.next
        if header.next:
            header = header.next
        nodemidle = nodemidle.next
    return nodemidle


def mergeLists(head1, head2):
    # create a node NULL
    node = None

    # head1 is empty then return header2
    if head1 is None:
        return head2

    # if header2 is empty then return head1
    if head2 is None:
        return head1

    # if head1 data is smaller or equal to header2 call again mergeLists
    if head1.body <= head2.body:
        node = head1
        node.next = mergeLists(head1.next, head2)

    else:
        node = head2
        node.next = mergeLists(head1, head2.next)

    # return the node.
    return node


if __name__ == "__main__":
    exercicio5()
