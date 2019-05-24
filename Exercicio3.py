import numpy as np


def exercicio3():
    word = "you"
    word2 = "you"

    if np.abs(len(word) - len(word2)) > 1:
        return False
    else:
        if len(word) >= len(word2):
            return comparate(word2, word)
        else:
            return comparate(word, word2)


def comparate(word, word2):
    j = 0
    findTypo = True
    for i, j in zip(range(0, len(word)), range(0, len(word2))):
        if word[i] != word2[j] and findTypo:
            findTypo = False
            i += 1
        elif word[i] != word2[j]:
            return False
    if j < len(word2) - 1 and not findTypo:
        return False
    else:
        return True


if __name__ == "__main__":
    print(exercicio3())
