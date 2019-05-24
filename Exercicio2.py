def exercicio2():
    word = "you"
    word2 = "yuo"
    hashWord = {}
    hashWord2 = {}
    difference = 0
    if len(word) == len(word2) and word[0] == word2[0]:
        for i in range(0, len(word)):
            # If word are different count for after check if difference / tamTotal are more than 2/3
            if word[i] != word2[i]:
                difference += 1

            add(word, i, hashWord)
            add(word2, i, hashWord2)

        # Check if permutation are more than 2/3
        if difference / len(word) > 2.0 / 3.0:
            return False

        # Verify if the two words have the same count of each letter
        for letter in hashWord:
            if not letter in hashWord2.keys():
                return False
            else:
                if hashWord[letter] != hashWord2[letter]:
                    return False

        return True
    return False


def add(word, i, hashWord):
    # Save count of all letter of each word
    if word[i] in hashWord.keys():
        qtdLetter = hashWord[word[i]] + 1
        hashWord.update({word[i]: qtdLetter})
    else:
        hashWord[word[i]] = 1


if __name__ == "__main__":
    print(exercicio2())
