import serial
import requests

arduino = serial.Serial("/dev/ttyACM0", 9600)
while True :
  msg = arduino.readline()
  msg = str(msg).split("\\")[0].split("\'")[1]
  gps_lat = "67N"
  gpa_long = "82E"
  data = {"data":a, "lat":gps_lat, "long":gps_long, "temperature":"0"}
  x = requests.put("https://oakhack.pythonanywhere.com/put", json=data)
  print(x.text)
