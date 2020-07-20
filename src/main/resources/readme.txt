http://localhost:8011/account-ws/users/5e06af61-3d25-42fa-a844-b648f6f856fb/accounts

	http://10.0.0.109:52693/users/5e06af61-3d25-42fa-a844-b648f6f856fb/accounts
	
	http://localhost:8011/account-ws/account/status/check
	
	
		docker run -d  
	-e "eureka.client.serviceUrl.defaultZone=http://uttam:uttam@172.31.47.217:8010/eureka" 
	-e "loggin.file=/api-logs/accounts-ws.log"
	-v /Users/uttamgiri/Desktop/Microservices/dev/log:/api-logs  -- for local file is container stopped data  deleted
	
	# v /home/ec2-user/api-logs:/api-logs
	-e "server.port=8989"  account microservice to run on specific port
	-p 8989:8989  and binding to port where it runs on docker  container
	uttamgiri32/personal-app-account
	
		for random port
		
		docker run -d  
	-e "eureka.client.serviceUrl.defaultZone=http://uttam:uttam@172.31.47.217:8010/eureka" 
	-e "loggin.file=/api-logs/accounts-ws.log"
	-v /Users/uttamgiri/Desktop/Microservices/dev/log  -- for local file is container stopped data  deleted
	 --network host  and binding to port where it runs on docker  container
	uttamgiri32/personal-app-account
	
	
	docker run -d -e "eureka.client.serviceUrl.defaultZone=http://uttam:uttam@172.31.47.217:8010/eureka" -e "logging.file.name=/api-logs/accounts-ws.log" -v /Users/uttamgiri/Desktop/Microservices/dev/log  -e "server.port=8989" -p 8989:8989 uttamgiri32/personal-app-account
	
	
	for random port
	docker run -d -e "eureka.client.serviceUrl.defaultZone=http://uttam:uttam@172.31.47.217:8010/eureka" -e "logging.file.name=/api-logs/accounts-ws.log" -v /Users/uttamgiri/Desktop/Microservices/dev/log:/api-logs  --network host  uttamgiri32/personal-app-account
	
	