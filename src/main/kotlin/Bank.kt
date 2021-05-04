//class for accounts
class Account(){
    var titular:String=""
    var numero:Int=0
    var saldo:Double=0.0
    var credito:Double=0.0
}
fun main(){
    //starting account
        val acesso = Account()
        print("Input starting money: ")
        acesso.saldo= readLine().toString().toDouble()
        print("Input the account owner's name: ")
        acesso.titular= readLine().toString()
        print("Input the account number: ")
        acesso.numero= Integer.valueOf(readLine().toString())

    //setting variables for run
        //numeric ones
        var operation=0 //default value to not run any operation

        var operationCost:Double= 0.0
        //Text
        val welcome= "• Welcome to ByteBank •"
        val welcome2= "• Hello ${acesso.titular} •"
        val operationCheck= "• What do you want to do? •"
        val exit= "• Have a good day! •"
        val currentSaldo="You currently have R$ "
        var confirmChoice:String = "aaa"

    //run
    var run:Int= 0 //used to keep the bank loop running
    println("") //used for spacing
    //bank welcomes log in
        println(welcome)
        println("You're logged in as ${acesso.titular}")
        println(currentSaldo + acesso.saldo)
        if(acesso.saldo<0) println("-= You're in debt! =-")
        println("====")
    //bank operations after logging in
        while(run==0){
                when {
                        operation==1->{
                            println("=====")
                            print("Input the value you're going to deposit: ")
                            operationCost=readLine().toString().toDouble()
                            println(operationCost)
                            acesso.saldo+=operationCost
                            println("-= Deposit successful! =-")
                            println(currentSaldo + acesso.saldo)
                            if(acesso.saldo<0) println("-= You're in debt! =-")
                            operation = 0
                        }
                        operation==2->{
                            println("=====")
                            print("Choose the value that you're going to Withdraw: ")
                            operationCost=readLine().toString().toDouble()
                            if(acesso.saldo>=operationCost){
                                acesso.saldo-=operationCost
                                println("-= Withdrawal successful! =-")
                                println(currentSaldo + acesso.saldo)
                            }else{
                                println("You don't have enough money in your account")
                                print("Still want to withdraw? Y/N - ")
                                confirmChoice= readLine().toString()
                                if(confirmChoice == "Y"){
                                    acesso.saldo-=operationCost
                                    println("-= Withdrawal successful! =-")
                                    println(currentSaldo + acesso.saldo)
                                    println("-= You're in debt! =-")
                                } else if(confirmChoice=="N"){
                                    println("-= Withdrawal canceled! =-")
                                    println(currentSaldo + acesso.saldo)
                                    if(acesso.saldo<0)println("-= You're in debt! =-")
                                }
                            }
                            operation=0
                        }
                        operation==3->{
                            println("=====")
                            println("Are you sure you want to exit? Y/N")
                            confirmChoice= readLine().toString()
                            if(confirmChoice=="Y") {
                                println(exit)
                                run = 1
                            }else{
                                println("=====")
                                operation=0
                            }
                        }
                        else ->{
                            println(operationCheck)
                            println("--------")
                            println("1 - Deposit")
                            println("2 - Withdraw")
                            println("3 - Exit")
                            println("--------")
                            print("Input your choice: ")
                            operation=Integer.valueOf(readLine())
                        }
                }
        }
}