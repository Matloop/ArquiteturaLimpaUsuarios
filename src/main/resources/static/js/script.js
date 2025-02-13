document.getElementById('userForm').addEventListener('submit', async function (e) {
    e.preventDefault();
    const button = this.querySelector('button');
    button.disabled = true;

    // Criar objetos separados para cada entidade
    const contato = {
        telefone: document.getElementById('telefone').value,
        email: document.getElementById('email').value
    };

    const documento = {
        cpf: document.getElementById('cpf').value,
        rg: document.getElementById('rg').value
    };

    const endereco = {
        rua: document.getElementById('rua').value,
        numero: document.getElementById('numero').value,
        cidade: document.getElementById('cidade').value,
        estado: document.getElementById('estado').value,
        cep: document.getElementById('cep').value
    };

    const cliente = {
        nome: document.getElementById('nome').value,
        dataNascimento: document.getElementById('dataNascimento').value,
        contato: contato,
        documento: documento,
        endereco: endereco
    };

    const messageEl = document.getElementById('message');

    try {
        const response = await fetch('http://localhost:8080/clientes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(cliente)
        });

        if (response.ok) {
            messageEl.textContent = 'Usuário cadastrado com sucesso!';
            messageEl.className = 'success';
            button.classList.add('success');
            this.reset();

            setTimeout(() => {
                button.classList.remove('success');
                button.disabled = false;
            }, 2000);
        } else {
            const error = await response.json();
            messageEl.textContent = `Erro: ${error.message}`;
            messageEl.className = 'error';
            button.disabled = false;
        }
    } catch (error) {
        messageEl.textContent = 'Erro ao conectar ao servidor.';
        messageEl.className = 'error';
        button.disabled = false;
    }
});

// Máscara para CPF
document.getElementById('cpf').addEventListener('input', function(e) {
    let value = e.target.value.replace(/\D/g, '');
    if (value.length <= 11) {
        value = value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
        e.target.value = value;
    }
});

// Máscara para telefone
document.getElementById('telefone').addEventListener('input', function(e) {
    let value = e.target.value.replace(/\D/g, '');
    if (value.length <= 11) {
        value = value.replace(/(\d{2})(\d{5})(\d{4})/, "($1) $2-$3");
        e.target.value = value;
    }
});

// Máscara para CEP
document.getElementById('cep').addEventListener('input', function(e) {
    let value = e.target.value.replace(/\D/g, '');
    if (value.length <= 8) {
        value = value.replace(/(\d{5})(\d{3})/, "$1-$2");
        e.target.value = value;
    }
});
