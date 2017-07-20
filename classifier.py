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


if __name__ == '__main__':
    data = load_CSV('analytics.device_data.hellotractor.30k')
