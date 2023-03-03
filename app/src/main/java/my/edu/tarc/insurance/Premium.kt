package my.edu.tarc.insurance


//Create a data class and let the variable holding the data, that it also a default value
data class Premium(var basic: Int = 0,
                   var extra: Int = 0,
                   var total: Int = 0)
