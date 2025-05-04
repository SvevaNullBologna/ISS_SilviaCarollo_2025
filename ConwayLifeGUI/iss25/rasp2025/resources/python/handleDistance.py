# handleDistance.py
import sys
import subprocess

# Read the distance passed from the Qak actor
distance = float(sys.argv[1])

min_val = 0
max_val = 150

def handle_distance(d):
    if d < min_val or d > max_val:
        print("ERROR: Distance out of range")
        subprocess.run(["python3", "ledPython25.py"])  # usa python3 se serve
        return False
    else:
        print(f"distance : {d}")
        return True

handle_distance(distance)
