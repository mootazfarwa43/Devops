pipeline {

	agent any

	stages {
		
		/*stage('Junit') {
			steps {
				sh 'mvn test'
			      } 
		}*/
		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
		       
		/*stage('SonarQube + JacOcO') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=devops  -Dsonar.host.url=http://192.168.1.18:9000/  -Dsonar.login=377c2af0436a40e68167dd85cb99403a24851dfa"

			}
		        post {
				always {

					jacoco execPattern: 'target/jacoco.exec'

				       }    
			    } 

		 }  
		stage('Sonatype/Nexus deploy') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			      }
		 } */
		/*stage('Docker Build and Push') {
                       steps {
                               withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
         			  sh 'printenv'
        			  sh 'docker build -t yossra12/springproject .'
	 			  sh 'docker tag yossra12/springproject yossra12/springproject:latest'
         			  sh 'docker push yossra12/springproject:latest'
         			}
     			  }
    		}*/
		 stage('Docker compose') {
      		      steps {
         parallel(
           "Docker compose": {
               sh 'docker-compose up '
           },
           "Delete running containers": {
		       sh 'sleep 3m '
               sh 'docker rm -f ci-spring ci-db'
           }
         )
       }
     }
	}  
			post {
				success {

					echo "passed"
				}    
			       failure {
				       echo "failed"
				
		                }

	}  

}
