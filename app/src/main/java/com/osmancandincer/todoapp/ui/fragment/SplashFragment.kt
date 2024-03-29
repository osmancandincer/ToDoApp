package com.osmancandincer.todoapp.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.auth.FirebaseAuth
import com.osmancandincer.todoapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        navController = Navigation.findNavController(view)

        val lottieAnimationView: LottieAnimationView = view.findViewById(R.id.lottieAnimationView)
        lottieAnimationView.setAnimation(R.raw.splash_anim)
        lottieAnimationView.playAnimation()


        Handler(Looper.myLooper()!!).postDelayed(Runnable {
           if (auth.currentUser != null){
               navController.navigate(R.id.splashToSignIn)
           }else{
               navController.navigate(R.id.splashToHome)
           }
        }, 3000)
    }

}