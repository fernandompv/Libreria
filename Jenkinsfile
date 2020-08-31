node{
    stage('limpiamos los contenedores e imagenes'){
        sh 'docker-compose down'
        sh 'docker rmi $(docker images -q)''
    }
    stage('Git clone'){
        git url: 'https://github.com/fernandompv/Libreria.git'
    }

    stage('build'){
        sh 'gradle build'
    }

    stage('despliegue'){
        sh 'docker-compose up -d'
    }
}