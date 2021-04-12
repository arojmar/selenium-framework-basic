**Basic Framework for testing (JAVA+Selenium)**


To run elasticSearch and Kibana:
> Be sure that you have your Max Virtual memory increased at least to 262144 
> (in terminal, you can set up as follows: <code>sudo sysctl -w vm.max_map_count=262144</code>)
> 

To configure Jenkins in local
> Run the following command in console
> <code> sudo docker run --add-host="localhost:192.168.0.6" -p 8082:8080 -p 50000:50000 --name jenkins -d -v /home/alfonso/Workspace/jenkins_home:/var/jenkins_home jenkins/jenkins </code>
