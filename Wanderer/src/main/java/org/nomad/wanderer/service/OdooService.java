package org.nomad.wanderer.service;

import org.nomad.wanderer.model.UsuarioOdoo;
import org.nomad.wanderer.model.UsuarioRegistroOdoo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OdooService {

    private static final String url = "http://localhost:8069/jsonrpc";
    private static final String db = "wandererodoo";

    //private static final String url = "http://192.168.8.102:8069/jsonrpc";
    //private static final String db = "jordi-odoo2";
    private static final int idAdmin = 2;
    private static final String passAdmin = "admin";


    public Object login(UsuarioOdoo usuario){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String email = usuario.getEmail();
        String pass = usuario.getPass();

        Map<String, Object> args = new HashMap<>();
        args.put("service", "common");
        args.put("method", "login");
        args.put("args", new Object[]{db, email, pass});

        JsonRpcRequest request = new JsonRpcRequest("call", args, 264030597);

        HttpEntity<JsonRpcRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(url, entity, Object.class);

    }

    //public Object registrarUsuarioOdoo

    public Object registrarUsuarioOdoo (UsuarioRegistroOdoo usuario){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String email = usuario.getEmail();
        String nombre = usuario.getNombre();
        String password = usuario.getPassword();

        Map<String, Object> args = new HashMap<>();
        args.put("service", "object");
        args.put("method", "execute");
        args.put("args", new Object[]{db, idAdmin, passAdmin,"res.users", "create", new Object[]{new HashMap<String, Object>() {{
            put("name", nombre);
            put("login", email);
            put("password", password);
        }}}});

        JsonRpcRequest request = new JsonRpcRequest("call", args, 2);
        HttpEntity<JsonRpcRequest> entity = new HttpEntity<>(request);

        return restTemplate.postForObject(url, entity, Object.class);

    }

    public Object getInfo(int idUsuario){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> args = new HashMap<>();
        args.put("service", "object");
        args.put("method", "execute");                                                                                  //Nombre de los campos en Odoo
        args.put("args", new Object[]{db, idAdmin,passAdmin,"res.users", "read",new Object[]{idUsuario}, new String[]{"name","login", "karma","premium"}});

        JsonRpcRequest request = new JsonRpcRequest("call", args, 2);
        HttpEntity<JsonRpcRequest> entity = new HttpEntity<>(request);

        return restTemplate.postForObject(url, entity, Object.class);
    }




}
