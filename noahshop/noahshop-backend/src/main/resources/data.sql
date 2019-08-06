INSERT
		   INTO OAUTH_CLIENT_DETAILS (
				CLIENT_ID,
				RESOURCE_IDS,
				CLIENT_SECRET,
				SCOPE,
				AUTHORIZED_GRANT_TYPES,
				WEB_SERVER_REDIRECT_URI,
				AUTHORITIES,
				ACCESS_TOKEN_VALIDITY,
				REFRESH_TOKEN_VALIDITY,
				ADDITIONAL_INFORMATION,
				AUTOAPPROVE )
		VALUES ('noahshop',
		        'v1',
		        '1234',
		        'read,write,trust',
		        'password,client_credentials',
		        '',
		        'ROLE_CLIENT',
		        null,
		        null,
		        '{}',
		        '');
