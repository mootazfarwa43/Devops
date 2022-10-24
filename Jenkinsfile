pipeline {

	agent any

	stages {
		
		stage('Junit') {
			steps {
				sh 'mvn test'
			      } 
		}
		stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
		       
		stage('SonarQube + JacOcO Analysis') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=Devops  -Dsonar.host.url=http://192.168.1.12:9000/  -Dsonar.login=c94b8196fdd3297563d50fdc87165007ddcba1eb"

			}
		        post {
				always {

					jacoco execPattern: 'target/jacoco.exec'

				       }    
			    } 

		 }  
		<!-- stage('Sonatype/Nexus deploy') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			      }
		 } 
		-->
	}  

}
