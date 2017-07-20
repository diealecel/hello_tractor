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


def discrim(matrix):
    edited_matrix = []

    for row in matrix:
        if row[8] == '1333110993' and row[7].find('2017-07-05') != -1:
            edited_matrix.append(row)

    return edited_matrix


if __name__ == '__main__':
    data = load_CSV('analytics.device_data.hellotractor.30k.csv')
    
    edited_matrix = discrim(data)

    with open('edit.csv', 'w') as edit:
        writer = csv.writer(edit)

        writer.writerows(edited_matrix)
