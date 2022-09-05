package com.santiago.AppDisney.security.controller;

import com.santiago.AppDisney.security.domain.Usuario;
import com.santiago.AppDisney.security.jwt.jwtUtil;
import com.santiago.AppDisney.security.repository.UsuarioRepository;
import com.santiago.AppDisney.security.responsejwt.ResponseJwt;
import com.santiago.AppDisney.security.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/authenticate")
    public ResponseJwt authenticate(@RequestBody Usuario jwtRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserName(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials", e);
        }
        final UserDetails userDetails
                = myUserDetailService.loadUserByUsername(jwtRequest.getUserName());
        final String token = jwtUtil.generateToken(userDetails);
        return new ResponseJwt(token);
    }
    @PostMapping("/register")
    public Usuario registerUser(@RequestBody @Valid Usuario usuario){
        Usuario usuarioentity = usuario;
        usuarioentity.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Usuario usuarioSaved = usuarioRepository.save(usuarioentity);
        return  usuarioSaved;
    }
}
