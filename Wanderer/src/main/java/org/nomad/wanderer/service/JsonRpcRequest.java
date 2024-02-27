package org.nomad.wanderer.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonRpcRequest {
    //@Schema(description = "Version del JsonRPC", example = "2.0")
    private String jsonrpc = "2.0";
    //@Schema(description = "Metodo de la Request JsonRPC", example = "call")
    private String method;
    //@Schema(description = "Parametros de la Request JsonRPC")
    private Map<String, Object> params;
    //@Schema(description = "Id de la Request JsonRPC", example = "264030597")
    private int id;

    // Constructor
    public JsonRpcRequest(String method, Map<String, Object> params, int id) {
        this.method = method;
        this.params = params;
        this.id = id;
    }
}
