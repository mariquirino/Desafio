import numpy as np


def exercicio3(word, word2):
    if np.abs(len(word) - len(word2)) > 1:
        return False
    else:
        if len(word) > len(word2):
            return comparate(word2, word)
        elif len(word) < len(word2):
            return comparate(word, word2)
        else:
            return comparateEqual(word, word2)


def comparateEqual(word, word2):
    findTypo = True
    for i in range(0, len(word)):
        if word[i] != word2[i]:
            if findTypo:
                findTypo = False
            else:
                return False

    return True


def comparate(word, word2):
    j = 0
    i = 0
    findTypo = True
    while i < len(word):
        if word[i] != word2[j]:
            if (findTypo):
                findTypo = False
                i -= 1
            else:
                return False
        j += 1
        i += 1

    return True


if __name__ == "__main__":
    print(exercicio3('mariana', 'marana'))
    print(exercicio3('testt', 'teste2'))
    print(exercicio3('mariana', 'mariiana'))
    print(exercicio3('mariana', 'mariianaa'))
    print(exercicio3('mariana', 'marianaaa'))
    print(exercicio3('mariana', 'marana'))
    print(exercicio3('mariana', 'mariyana'))
    print(exercicio3('mariana', 'mariyanaa'))
