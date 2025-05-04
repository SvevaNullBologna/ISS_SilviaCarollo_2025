# File: sonarstop.py
import RPi.GPIO as GPIO

# Pulisci i pin GPIO
GPIO.cleanup()
print("Sonar stopped.")
