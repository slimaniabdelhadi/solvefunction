package com.slimaniabdelhadib.solvefunction

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       button.setOnClickListener {
try {
    val Ca = Eda.text.toString().toDouble()
    val Cb = Edb.text.toString().toDouble()
    val Cc = Edc.text.toString().toDouble()
    val Cd = Edd.text.toString().toDouble()
    val Ce = Ede.text.toString().toDouble()
    val Cf = Edf.text.toString().toDouble()
    val Cg = Edg.text.toString().toDouble()
    val Ch = Edi.text.toString().toDouble()


    var Xa = bora.text.toString().toDouble()
    var Xb = borb.text.toString().toDouble()
    val Epc = edEpc.text.toString().toDouble()
    var Xc = 0.0
    var Recalculations = 0


    var yc = 10000000.0
    var ya =
        Ca * Xa.pow(7) + Cb * Xa.pow(6) + Cc * Xa.pow(5) + Cd * Xa.pow(4) + Ce * Xa.pow(3) + Cf * Xa.pow(
            2
        ) + Cg * Xa + Ch
    var yb =
        Ca * Xb.pow(7) + Cb * Xb.pow(6) + Cc * Xb.pow(5) + Cd * Xb.pow(4) + Ce * Xb.pow(3) + Cf * Xb.pow(
            2
        ) + Cg * Xb + Ch

    if (Ca == 0.0 && Ca == 0.0 && Cb == 0.0 && Cd == 0.0 && Ce == 0.0 && Cf == 0.0 && Cg == 0.0 && Ch == 0.0 && Ca == 0.0 && Cb == 0.0) {
        resultat.text = " You didn't enter the data"
    } else if (Ca == 0.0 && Ca == 0.0 && Cb == 0.0 && Cd == 0.0 && Ce == 0.0 && Cf == 0.0 && Cg != 0.0) {
        Xc = (-Ch) / Cg
        ya = Cg * Xc + Ch
        resultat.text = " solution is $Xc \n" +
                " f(" + Xc + ") = " + ya

    } else if (Ca == 0.0 && Ca == 0.0 && Cb == 0.0 && Cd == 0.0 && Ce == 0.0 && Cf != 0.0) {
        val delta = (Cg.pow(2)) - (4 * Cf * Ch)
        val X1: Double
        val X2: Double
        when {
            (delta > 0.0) -> {

                X1 = ((-Cg) + sqrt(delta)) / (2 * Cf)
                X2 = ((-Cg) - sqrt(delta)) / (2 * Cf)
                ya = Cf * X1 * X1 + Cg * X1 + Ch
                yb = Cf * X2 * X2 + Cg * X2 + Ch
                resultat.text = "There are two solutions X1 and X2\n" +
                        "\n" +
                        " X1 = " + X1 + " \n"+
                        " f(" + X1 + ") = " + ya + "\n" +
                        "\n" +
                        " X2 = " + X2 +" \n"+
                        " f(" + X2 + ") = " + yb
            }
            (delta == 0.0) -> {
                X1 = (-Cg) / (2 * Cf)
                ya =Cf*X1.pow(2)+Cg*X1+Ch
                resultat.text = " There is a double solution \n" +
                        "\n" +
                        " X = " + X1 + "\n"+
                        " f(" + X1 + ") = $ya"
            }
            (delta < 0.0) -> resultat.text =
                " No solution because the function f(x) does not pass on zero "
        }
    } else if (ya == 0.0) {
        resultat.text = " f(" + Xa + ") = 0  \n" +
                " So a is a solution to f(x)"
    } else if (yb == 0.0) {
        resultat.text = "  f(" + Xb + ") = 0  \n" +
                " So b is a solution to f(x)"
    } else if (Xa == Xb) {
        resultat.text = " Cannot calculate because: a = b"
    } else if (Epc < 0.00000000000000000001) {
        resultat.text = " Cannot calculate because: Eps is too small\n" +
                " The smallest value is 0.000000000000000000001"
    } else if (ya < 0 && yb < 0) {

        resultat.text = " f(" + Xa + ") = " + ya + "\n" +
                " f(" + Xb + ") = " + yb + "\n" +
                "The solution cannot be found because f(a) and f(b) are completely negative"
    } else if (ya > 0 && yb > 0) {
        resultat.text = " f(" + Xa + ")= " + ya + "\n" +
                " f(" + Xb + ")= " + yb + "\n" +
                " The solution cannot be found because f(a) and f(b) are completely  positive"
    } else if (Xa < Xb) {

        resultat.text = "Be patient a little this takes some time"
        while (yc > Epc || yc < -Epc) {
            Xc = (Xa + Xb) / 2
            yc =
                Ca * Xc.pow(7) + Cb * Xc.pow(6) + Cc * Xc.pow(5) + Cd * Xc.pow(4) + Ce * Xc.pow(3) + Cf * Xc.pow(
                    2
                ) + Cg * Xc + Ch
            val yyc =
                7 * Ca * Xc.pow(6) + 6 * Cb * Xc.pow(5) + 5 * Cc * Xc.pow(4) + 4 * Cd * Xc.pow(3) + 3 * Ce * Xc.pow(
                    2
                ) + 2 * Cf * Xc + Cg

            Recalculations += 1
            if ((yc >= 0.0 && yyc >= 0.0) || (yc <= 0.0 && yyc <= 0.0)) {
                Xb = Xc
            } else if ((yc < 0.0 && yyc > 0.0) || (yc > 0.0 && yyc <= 0.0)) {
                Xa = Xc
            } else {
                resultat.text = "Maybe in it Error \n" +
                        "Try again"
            }
        }
        if (yc>=0) {
            resultat.text = " the Solution is : " + Xc + "\n" +
                    "\n" +
                    "and f(" + Xc + ") = " + yc + " < Epc\n" +
                    "\n" +
                    "Number of recalculations R :\n" +
                    "  R =  $Recalculations"
        }else{
            resultat.text = " the Solution is : " + Xc + "\n" +
                    "\n" +
                    "and f(" + Xc + ") = " + yc + " \n" +
                    "\n" +
                    "and |"+yc+"| = "+(-yc)+" < Epc\n"+
                    "\n" +
                    "Number of recalculations R :\n" +
                    "  R =  $Recalculations"
        }


    } else if (Xa > Xb) {


        resultat.text = " Be patient a little this takes some time"

        while (yc > Epc || yc < -Epc) {

            Xc = (Xb + Xa) / 2
            yc =
                Ca * Xc.pow(7) + Cb * Xc.pow(6) + Cc * Xc.pow(5) + Cd * Xc.pow(4) + Ce * Xc.pow(3) + Cf * Xc.pow(2) + Cg * Xc + Ch
            val yyc =
                7 * Ca * Xc.pow(6) + 6 * Cb * Xc.pow(5) + 5 * Cc * Xc.pow(4) + 4 * Cd * Xc.pow(3) + 3 * Ce * Xc.pow(2) + 2 * Cf * Xc + Cg
            Recalculations += 1

            if ((yc <= 0.0 && yyc >= 0.0) || (yc >= 0.0 && yyc <= 0.0)) {
                Xb = Xc
            } else if ((yc > 0.0 && yyc > 0.0) || (yc < 0.0 && yyc < 0.0)) {
                Xa = Xc
            } else {
                resultat.text = "Maybe in it error\n" +
                        "Try again"
            }
        }
        if (yc>=0) {
            resultat.text = " the Solution is : " + Xc + "\n" +
                    "\n" +
                    "and f(" + Xc + ") = " + yc + " < Epc\n" +
                    "\n" +
                    "Number of recalculations R :\n" +
                    "  R =  $Recalculations"
        }else{
            resultat.text = " the Solution is : " + Xc + "\n" +
                    "\n" +
                    "and f(" + Xc + ") = " + yc + " \n" +
                    "\n" +
                    "and |"+yc+"| = "+(-yc)+" < Epc\n"+
                    "\n" +
                    "Number of recalculations R :\n" +
                    "  R =  $Recalculations"
        }
    }
    }catch (ex:Exception){resultat.text = ex.message.toString()}
       }
    }
}
