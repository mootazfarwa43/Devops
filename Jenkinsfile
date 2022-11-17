
pipeline {
  agent {label "maven"}

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                echo "Getting Project from Git"; 
                git branch: "akram", 
                url: "https://github.com/mootazfarwa43/Devops.git";
                sh "mvn -version"
                
                

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                 //   junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
          stage('UNIT testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn test'
                }
            }
        }
        
         stage('Integration testing'){
            
            steps{
                
                script{
                    
                    sh 'mvn verify -DskipUnitTests'
                }
            }
        }
        
        
         stage('Maven build'){
            
            steps{
                
                script{
                    
                    sh 'mvn clean install'
                }
            }
        }
         stage('MVN SONAREQUBE STAGE') {
            steps {
                sh'mvn sonar:sonar -Dsonar.login=2f76bab51dad5b5a9c1f1bd16ae8deb05886e3d0'
                }
           
        }
         

       
        
    }
}
