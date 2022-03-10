package com.example.testproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.testproject.data.TestProfile
import com.example.testproject.databinding.ProfileBinding

/**
 * Fragment that displays the user's profile
 */
class Profile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate and bind the profile.xml layout for the Profile fragment
        val binding = ProfileBinding.inflate(layoutInflater)

        // Modify EditText views using data from TestProfile
        binding.takername.setText(TestProfile.takername)
        binding.neednumber.setText(TestProfile.need)



        /*
        binding.modify.setOnClickListener { view: View ->
            /**
             * Convert age text into a String object, which provides a toInt
             * method that is then compared with the value 18.
             */
            if(binding.age.text.isEmpty()
                || binding.name.text.isEmpty()
                || binding.address.text.isEmpty()) {
                    //Show the not modified fragment if name, address, or age aren't inputted
                    view.findNavController()
                    .navigate(R.id.action_profile_to_notModified)
            }
            else if ((binding.age.text.toString().toInt() < 18)) {
                // Show the not modified fragment if the person is a minor
                view.findNavController()
                    .navigate(R.id.action_profile_to_notModified)
            }
            else {
                // Show the modified fragment if the person is not a minor
                view.findNavController()
                    .navigate(ProfileDirections
                        .actionProfileToModified(binding.name.text.toString()))

            }

        }
        */



        /**
         * Do not implement unless working on 6.2 Model 1
         * Modify the navigation action by first check for changes in any of the profile data using
         * the EditText elements of the fragment. If there are changes, navigate to Modified
         * fragment, otherwise navigate to the NotModified fragment.
         */

        /**
         * Do not implement unless working on 6.2 Model 2
         * Replace resource ID of the navigation actions with method calls using the
         * ProfileDirections object. Pass parameters accordingly.
         */

        // Return a link to the layout root
        return binding.root
    }
}