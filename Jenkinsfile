node {

   stage('Clone Repository') {
        // Get some code from a GitHub repository
        git 'https://github.com/msomi22/daraja_demo.git'
    
   }
   stage('Build Maven Image') {
        docker.build("maven-build }
   
   stage('Run Maven Container') {
       
        //Remove maven-build-container if it exists
        sh " docker rm -f daraja:latest"
        
        //Run maven image
        sh "docker run --rm --name daraja:latest maven-build"
   }
   
   stage('Deploy Spring Boot Application') {
        
         //Remove maven-build-container if it exists
        // sh " docker rm -f daraja:latest"
       
        sh "docker run --name daraja:latest --volumes-from maven-build-container -d -p 2020:8082 denisdbell/petclinic-deploy"
   }

}
