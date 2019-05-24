def exercicio1():
    word = ['a', ' ', 'b', ' ', ' ']
    isSpace = True
    tamEnd = 0
    for i in range(len(word) - 1, -1, -1):
        # print(word[i])
        if isSpace and word[i] == ' ':
            tamEnd += 1
        elif word[i] != ' ':
            isSpace = False
            word[tamEnd + i] = word[i]
        else:
            isSpace = False;
            word[tamEnd + i] = '2'
            word[tamEnd + i - 1] = '3'
            word[tamEnd + i - 2] = '&'
            tamEnd -= 2
    print(word)


if __name__ == "__main__":
    exercicio1()
