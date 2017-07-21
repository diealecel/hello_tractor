import csv
from collections import deque
from numpy import mean

WINDOW_SIZE = 700

def load_CSV(filename):
    matrix = []

    with open(filename) as f:
        reader = csv.reader(f)

        for row in reader:
            string_row = []

            for value in row:
                string_row.append(value)

            matrix.append(string_row)

    return matrix


def load_init(data):
    window = deque()

    for i in xrange(WINDOW_SIZE):
        window.append(abs(int(data[i + 1][1]) - int(data[i][1])))

    return window


if __name__ == '__main__':
    data = load_CSV('edit.csv')

    data.sort(key = lambda point: point[7])

    window = load_init(data)
    print mean(window)
    
    for i in xrange(WINDOW_SIZE, len(data) - 1): # Minus one bc of data[i + 1]
        window.popleft()

        window.append(abs(int(data[i + 1][1]) - int(data[i][1])))

        print mean(window)
