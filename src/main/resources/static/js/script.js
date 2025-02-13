document.getElementById('tipoUsuario').addEventListener('change', function() {
    const tipo = this.value;
    const camposFuncionario = document.getElementById('camposFuncionario');
    const camposGerente = document.getElementById('camposGerente');

    camposFuncionario.classList.add('hidden');
    camposGerente.classList.add('hidden');

    if (tipo === 'funcionario') {
        camposFuncionario.classList.remove('hidden');
    } else if (tipo === 'gerente') {
        camposFuncionario.classList.remove('hidden');
        camposGerente.classList.remove('hidden');
    }
});

document.getElementById('userForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    const button = this.querySelector('button');
    button.disabled = true;

    const tipoUsuario = document.getElementById('tipoUsuario').value;
    const baseUrl = 'http://localhost:8080/';
    let endpoint = '';

    const baseUser = {
        nome: document.getElementById('nome').value,
        dataNascimento: document.getElementById('dataNascimento').value,
        contato: {
            telefone: document.getElementById('telefone').value,
            email: document.getElementById('email').value
        },
        documento: {
            cpf: document.getElementById('cpf').value,
            rg: document.getElementById('rg').value
        },
        endereco: {
            rua: document.getElementById('rua').value,
            numero: document.getElementById('numero').value,
            cidade: document.getElementById('cidade').value,
            estado: document.getElementById('estado').value,
            cep: document.getElementById('cep').value
        }
    };

    let userData;
    switch(tipoUsuario) {
        case 'cliente':
            endpoint = 'clientes';
            userData = {
                ...baseUser,
                dataRegistro: new Date().toISOString().split('T')[0],
                status: 'ATIVO'
            };
            break;

        case 'funcionario':
            endpoint = 'funcionarios';
            userData = {
                ...baseUser,
                salario: parseFloat(document.getElementById('salario').value),
                cargo: document.getElementById('cargo').value,
                departamento: document.getElementById('departamento').value
            };
            break;

        case 'gerente':
            endpoint = 'gerentes';
            userData = {
                ...baseUser,
                salario: parseFloat(document.getElementById('salario').value),
                cargo: document.getElementById('cargo').value,
                departamento: document.getElementById('departamento').value,
                nivelAutorizacao: parseInt(document.getElementById('nivelAutorizacao').value)
            };
            break;
    }

    try {
        const response = await fetch(`${baseUrl}${endpoint}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });

        if (response.ok) {
            showMessage('Usuário cadastrado com sucesso!', 'success');
            this.reset();
            setTimeout(() => {
                button.disabled = false;
            }, 2000);
        } else {
            const error = await response.json();
            showMessage(`Erro: ${error.message}`, 'error');
            button.disabled = false;
        }
    } catch (error) {
        showMessage('Erro ao conectar ao servidor.', 'error');
        button.disabled = false;
    }
});

// Funções de máscara
document.getElementById('cpf').addEventListener('input', function(e) {
    let value = e.target.value.replace(/\D/g, '');
    if (value.length <= 11) {
        value = value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
        e.target.value = value;
    }
});

document.getElementById('telefone').addEventListener('input', function(e) {
    let value = e.target.value.replace(/\D/g, '');
    if (value.length <= 11) {
        value = value.replace(/(\d{2})(\d{5})(\d{4})/, "($1) $2-$3");
        e.target.value = value;
    }
});

document.getElementById('cep').addEventListener('input', function(e) {
    let value = e.target.value.replace(/\D/g, '');
    if (value.length <= 8) {
        value = value.replace(/(\d{5})(\d{3})/, "$1-$2");
        e.target.value = value;
    }
});

function showMessage(text, type) {
    const messageEl = document.getElementById('message');
    messageEl.textContent = text;
    messageEl.className = type;
}