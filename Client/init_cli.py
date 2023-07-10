import requests, time
from tls import *
client_id = '9088'

def send_file(file_path, url, headers):
	with open(file_path, 'rb') as file:
		files = {'proof': file}
		response = requests.post(url, files=files, headers=headers)
		if response.status_code == 200:
			print("File sent successfully.")
		else:
			print("Error sending file. Status code:", response.status_code)

def save_file(response, path):
	with open(path, 'wb') as file:
		file.write(response.content)



def main():
	print("Connecting to middlebox as client "+client_id)
	url = "http://localhost:5001/prover-key"
	headers = {'Client-ID': client_id}
	while True:
		try:
			response = requests.get(url, headers=headers)
		except requests.ConnectionError:
			print("Retrying...")
			time.sleep(2)
			continue
		print("Connected!")
		break
	# Save the response file
	save_file(response, 'test.bin')
	print("Circuit saved as: test.bin")
	# Retrieve the Client-Token header
	client_token = response.headers.get('Client-Token')
	if client_token:
		with open('token.txt', 'w') as token_file:
			token_file.write(client_token)
		print("Authentication succeeded, Client-Token obtained.")


	while True:
		prompt=input("Setup done. Press enter to generate request or 'q' to quit: ")
		if prompt.lower() == "":
			function = "/function/run"
			keepalive = False
			print("Sending HTTP request(s) to server...")
			(random_id, numPackets) = make_tls_connection(function, keepalive)
			for pkt in numPackets:
				file_path = "proof.txt"		#TODO: must be replaced with proof+random_id+numpacket+.txt
				url = "http://localhost:5001/prove"
				print("Random ID: "+random_id.hex())
				headers = {'Client-ID': client_id, 'Random-ID':random_id.hex(), 'PacketNum': pkt}
				send_file(file_path, url, headers)
		elif prompt.lower() == "q":
			print("Exiting the program.")
			break
		else:
			print("Invalid input. Try again.")

	   

if __name__=='__main__':
	main()
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

