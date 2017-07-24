import csv
from collections import deque
from numpy import mean
import matplotlib.pyplot as plt

import numpy as np

WINDOW_SIZE = 5
PACKET_END = 400
PACKET_START = 0


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
        inter = abs(int(data[i + 1][1]) - int(data[i][1]))
        window.append(inter if inter <= 180 else 360 - inter)

    return window


if __name__ == '__main__':
    data = load_CSV('edit.csv')

    data.sort(key = lambda point: point[7]) # Sort chronologically

    for i in xrange(17):
        data.pop(0)

    for thing in data:
        print thing[7]

    window = load_init(data)
    #print mean(window)

    total = []
    total.append(mean(window))

    tracker = []
    tracker.append(str(len(total) - 1) + ', ' + str(data[len(total)][7]))
    
    for i in xrange(WINDOW_SIZE, len(data) - 1): # Minus one bc of data[i + 1]
        window.popleft()
        
        inter = abs(int(data[i + 1][1]) - int(data[i][1]))

        window.append(inter if inter <= 180 else 360 - inter)
        total.append(mean(window))

        tracker.append(str(len(total) - 1) + ', ' + str(data[len(total)][7]))


        #print mean(window)
    
    total = total[PACKET_START : PACKET_END]
    tracker = tracker[PACKET_START : PACKET_END]

    #tracker.sort()
    
    for thing in tracker:
        print thing
    
    print 'Plotted up to ' + data[len(total)][7]

    plt.plot(range(len(total)), total, marker = 'o', linestyle = '--')


    plt.xticks(np.arange(min(range(len(total))), max(range(len(total)))+1, 15.0))

    plt.axhline(y=70, color='r', linestyle='-')

    plt.title('Heading change over time, window = ' + str(WINDOW_SIZE))
    plt.xlabel('packet number')
    plt.ylabel('heading change (degrees)')
    #plt.text('wow')
    plt.show()
