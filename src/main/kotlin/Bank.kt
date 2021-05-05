//class for accounts
class Account(){
    var titular:String=""
    var numero:Int=0
    var saldo:Double=0.0
    var credito:Double=0.0
}
class Operations(){
    var value:Double=0.0
    fun deposit(account:Account){
        value= readLine().toString().toDouble()
        account.saldo+=value
    }
    fun withdraw(account: Account){
        value= readLine().toString().toDouble()
        if(account.saldo>=value){
            account.saldo-=value
            println("-= Withdrawal Successful! =-")
        }else{
            println("You're currently in debt! \n Are you sure you want to withdraw? (Y/N)")
            if(operationCheck()=="Y"){
                account.saldo-=value
                println("-= Withdrawal Successful! =-")
            }else{
                println("-= Withdrawal Canceled! =-")
            }
        }
    }
    fun exit():Int{
        println("Are you sure you want to exit?(Y/N)")
        return if(operationCheck()=="Y"){
            1
        } else{
            0
        }
    }
}
fun main(){
    //starting account
        val operations = Operations()
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
        //Text
        val welcome= "• Welcome to ByteBank •"
        val welcome2= "• Hello ${acesso.titular} •"
        val operationCheck= "• What do you want to do? •"
        val exit= "• Have a good day! •"
        val currentSaldo="You currently have R$ "
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
                            print("Choose the value that you're going to deposit: R$")
                            operations.deposit(acesso)
                            println(currentSaldo + acesso.saldo)
                            if(acesso.saldo<0) println("-= You're in debt! =-")
                            operation = 0
                        }
                        operation==2->{
                            println("=====")
                            print("Choose the value that you're going to Withdraw: R$")
                            operations.withdraw(acesso)
                            println(currentSaldo + acesso.saldo)
                            if(acesso.saldo<0) println("-= You're in debt! =-")
                            operation=0
                        }
                        operation==3->{
                            println("=====")
                            operation=operations.exit()
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
        println(exit)
}
//Function to save lines when doing Yes/No checks
fun operationCheck():String{
    return readLine().toString()
}