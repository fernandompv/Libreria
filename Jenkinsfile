node{
    stage('Git clone'){
        git url: 'https://github.com/fernandompv/Libreria.git'
		git clone: 'https://github.com/fernandompv/Libreria.git'
    }
    stage('build'){
        sh 'gradle clean'
        sh 'gradle check'
        sh 'gradle build'
    }
    stage('despliegue'){
        sh 'docker-compose down'
        sh 'docker-compose up -d'
    }
}