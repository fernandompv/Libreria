pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        git(url: 'https://github.com/fernandompv/Libreria.git', branch: 'master')
      }
    }

    stage('error') {
      steps {
        withGradle() {
          sh '''.7gradlew build
'''
        }

      }
    }

  }
}