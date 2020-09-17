node{
    stage('Git clone'){
        git 'https://github.com/fernandompv/Libreria.git'
    }
    stage('build'){
		sh 'ls'
		sh 'cd ..'
		sh 'cd Compilacion'
        sh 'gradle clean'
        sh 'gradle check'
        sh 'gradle build'
    }
    stage('despliegue'){
        sh 'docker-compose down'
        sh 'docker-compose up -d'
    }
}