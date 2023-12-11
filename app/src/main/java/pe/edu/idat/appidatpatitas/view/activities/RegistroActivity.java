package pe.edu.idat.appidatpatitas.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import pe.edu.idat.appidatpatitas.R;
import pe.edu.idat.appidatpatitas.databinding.ActivityRegistroBinding;
import pe.edu.idat.appidatpatitas.retrofit.request.RegistroRequest;
import pe.edu.idat.appidatpatitas.retrofit.response.RegistroResponse;
import pe.edu.idat.appidatpatitas.viewmodel.AuthViewModel;

public class RegistroActivity extends AppCompatActivity {

    private AuthViewModel authViewModel;
    private ActivityRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        authViewModel = new ViewModelProvider(this)
                .get(AuthViewModel.class);
        RegistroRequest registroRequest = new RegistroRequest();
        registroRequest.setUsuario("hlopez");
        registroRequest.setNombres("Henry");
        registroRequest.setApellidos("Lopez");
        registroRequest.setEmail("hlopez@gmail.com");
        authViewModel.registroUsuario(registroRequest);
        authViewModel.registroResponseMutableLiveData.observe(this,
                new Observer<RegistroResponse>() {
                    @Override
                    public void onChanged(RegistroResponse registroResponse) {
                        Snackbar.make(binding.getRoot(),
                                registroResponse.getMensaje()
                                ,Snackbar.LENGTH_LONG).show();

                    }
                });
    }
}