package br.com.alura.livrariaapi.util;

import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

public class UriFactory {
	
	
	public static URI getURI(UriComponentsBuilder uriBuilder,String path, Long id) {
		return uriBuilder.path(path).buildAndExpand(id).toUri();
	}
}
