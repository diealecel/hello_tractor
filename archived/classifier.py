import matplotlib.pyplot as plt
import csv

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


def make_col(matrix, col):
    column = []

    for row in matrix:
        column.append(row[col])

    return column


if __name__ == '__main__':
    data = load_CSV('analytics.device_data.hellotractor.30k.csv')
    
    heading = make_col(data, 4)
    speed = make_col(data, 5)

    del heading[0]
    del speed[0]

    plt.plot(heading, speed, 'ro')
    plt.show()

