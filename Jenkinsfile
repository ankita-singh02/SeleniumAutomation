properties([parameters([choice(choices: 'master\nversion1.0', description: 'Select branch to build', name: 'Git Branches')])])


pipeline {
    agent any 
    stages {
        stage('----clean---') { 
            steps {
               bat "mvn clean"
            }
        }
        stage('----Test----') { 
            steps {
                bat "mvn test" 
            }
        }
         stage('---Deploy---') { 
            steps {
                 bat "mvn package"
            }
        }
        
    }
}
