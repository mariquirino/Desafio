def exercicio1():
    word = ['a', ' ', 'b', ' ', ' ']
    isSpace = True
    end = 0
    for i in range(len(word) - 1, -1, -1):
        if isSpace and word[i] == ' ':
            end += 1
        elif word[i] != ' ':
            isSpace = False
            word[end + i] = word[i]
        else:
            isSpace = False
            word[end + i] = '2'
            word[end + i - 1] = '3'
            word[end + i - 2] = '&'
            end -= 2
    print(word)


if __name__ == "__main__":
    exercicio1()
