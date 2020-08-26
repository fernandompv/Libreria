pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        git(url: 'https://github.com/fernandompv/Libreria.git', branch: 'master')
        sh 'git clone \'https://github.com/fernandompv/Libreria.git\''
      }
    }

    stage('error') {
      steps {
        withGradle() {
          sh '''gradle build
'''
        }

      }
    }

  }
}