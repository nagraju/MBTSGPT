package com.example.mbtsgpt.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
//import androidx.navigation.fragment.findNavController;
import com.example.mbtsgpt.MainActivity;
import com.example.mbtsgpt.R;
import com.example.mbtsgpt.databinding.FragmentConnectionErrorBinding;
import com.example.mbtsgpt.databinding.FragmentHomeBinding;

import kotlin.Suppress;

public class ConnectionError extends Fragment {
    private FragmentConnectionErrorBinding binding = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentConnectionErrorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String fromLocation = null;
        if (getArguments() != null) {
            fromLocation = getArguments().getString("last_location");
        }







        binding.tryAgain.setOnClickListener(v -> {
            if (checkForInternet(view.getContext())) {
                if ("homePage".equals(fromLocation)) {
                    NavHostFragment.findNavController(this).navigate(R.id.action_connection_error_to_nav_home);
                } else if ("loginPage".equals(fromLocation)) {
                    NavHostFragment.findNavController(this).navigate(R.id.action_connection_error_to_login);
                } else {
                    NavHostFragment.findNavController(this).navigate(R.id.action_connection_error_to_login);
                }
            } else {
                Toast.makeText(view.getContext(), "Still Internet Connection Not Working", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean checkForInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null) return false;
            NetworkCapabilities activeNetwork = connectivityManager.getNetworkCapabilities(network);
            if (activeNetwork == null) return false;

            return activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
        } else {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo == null)
                return false;
            else
            return  networkInfo.isConnectedOrConnecting();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

