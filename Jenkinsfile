pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        git(url: 'https://github.com/fernandompv/Libreria.git', branch: 'master')
      }
    }

    stage('') {
      steps {
        withGradle() {
          sh '''gradle build
'''
        }

      }
    }

  }
}