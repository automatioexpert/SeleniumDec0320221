pipeline{
    
    agent any
    
    stages{
        
        stage("Build"){
            steps{
                echo("Build")
            }
        }
        
        stage("Run UTs"){
            steps{
                echo("RUN UTs")
            }
        }
        
         stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
        
        stage("Run Automation Test"){
            steps{
                echo("running automation  test cases")
            }
        }
        
        stage("Deploy to stage"){
            steps{
                echo("deploy to stage")
            }
        }
        
        stage("sanity test"){
            steps{
                echo("sanity test on stage env")
            }
        }
        
        stage("Deploy to PROD"){
            steps{
                echo("deploy to prod")
            }
        }
        
    }
    
    
    
}