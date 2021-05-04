import java.util.Scanner
fun main(){
    //setting variables for run
        //numeric ones
        var operation=0 //default value to not run any operation
        print("Input starting money: ")
        var saldo=readLine().toString().toDouble()
        var operationCost:Double= 0.0
        //Text
        val welcome= "• Welcome to ByteBank •"
        val operationCheck= "• What do you want to do? •"
        val exit= "• Have a good day! •"
        val currentSaldo="You currently have R$ "
        var confirmChoice:String = "aaa"

    //run
    var run:Int= 0 //used to keep the bank loop running
    print("Use bank as: ")
    val user= readLine()

    println("") //used for spacing
    //bank welcomes log in
        println(welcome)
        println("You're logged in as $user")
        println(currentSaldo + saldo)
        if(saldo<0) println("-= You're in debt! =-")
        println("====")
    //bank operations after logging in
        while(run==0){
                when {
                        operation==1->{
                            println("=====")
                            print("Input the value you're going to deposit: ")
                            operationCost=readLine().toString().toDouble()
                            println(operationCost)
                            saldo+=operationCost
                            println("-= Deposit successful! =-")
                            println(currentSaldo +saldo)
                            if(saldo<0) println("-= You're in debt! =-")
                            operation = 0
                        }
                        operation==2->{
                            println("=====")
                            print("Choose the value that you're going to Withdraw: ")
                            operationCost=readLine().toString().toDouble()
                            if(saldo>=operationCost){
                                saldo-=operationCost
                                println("-= Withdrawal successful! =-")
                                println(currentSaldo + saldo)
                            }else{
                                println("You don't have enough money in your account")
                                print("Still want to withdraw? Y/N - ")
                                confirmChoice= readLine().toString()
                                if(confirmChoice == "Y"){
                                    saldo-=operationCost
                                    println("-= Withdrawal successful! =-")
                                    println(currentSaldo + saldo)
                                    println("-= You're in debt! =-")
                                } else if(confirmChoice=="N"){
                                    println("-= Withdrawal canceled! =-")
                                    println(currentSaldo + saldo)
                                    if(saldo<0)println("-= You're in debt! =-")
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