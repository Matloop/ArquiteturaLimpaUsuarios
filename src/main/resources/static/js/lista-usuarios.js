document.addEventListener('DOMContentLoaded', async () => {
    const userList = document.getElementById('userList');

    try {
        const [clientes, funcionarios, gerentes] = await Promise.all([
            fetch('http://localhost:8080/clientes').then(res => res.json()),
            fetch('http://localhost:8080/funcionarios').then(res => res.json()),
            fetch('http://localhost:8080/gerentes').then(res => res.json())
        ]);

        const allUsers = [...clientes, ...funcionarios, ...gerentes];

        if (allUsers.length === 0) {
            userList.innerHTML = '<p style="text-align: center; color: var(--label-color);">Nenhum usuário cadastrado</p>';
            return;
        }

        userList.innerHTML = allUsers.map(user => `
            <div class="user-card" data-id="${user.id}" data-type="${user.hasOwnProperty('nivelAutorizacao') ? 'gerente' : user.hasOwnProperty('salario') ? 'funcionario' : 'cliente'}">
                <div class="user-type-badge ${user.hasOwnProperty('nivelAutorizacao') ? 'gerente-badge' : user.hasOwnProperty('salario') ? 'funcionario-badge' : 'cliente-badge'}">
                    ${user.hasOwnProperty('nivelAutorizacao') ? 'Gerente' : user.hasOwnProperty('salario') ? 'Funcionário' : 'Cliente'}
                </div>
                <h3>${user.nome}</h3>
                <p>CPF: ${user.documento.cpf}</p>
                <p>Email: ${user.contato.email}</p>
                <p>Telefone: ${user.contato.telefone}</p>
                <p>Endereço: ${user.endereco.rua}, ${user.endereco.numero} - ${user.endereco.cidade}/${user.endereco.estado}</p>
                ${user.salario ? `<p>Salário: R$ ${user.salario.toFixed(2)}</p>` : ''}
                ${user.cargo ? `<p>Cargo: ${user.cargo}</p>` : ''}
                ${user.nivelAutorizacao ? `<p>Nível Autorização: ${user.nivelAutorizacao}</p>` : ''}
                <button onclick="deleteUser('${user.hasOwnProperty('nivelAutorizacao') ? 'gerentes' : user.hasOwnProperty('salario') ? 'funcionarios' : 'clientes'}', ${user.id})" class="delete-btn">
                    <span>Excluir</span>
                </button>
            </div>
        `).join('');
    } catch (error) {
        userList.innerHTML = '<p style="text-align: center; color: var(--error-color);">Erro ao carregar usuários</p>';
        console.error('Erro ao carregar usuários:', error);
    }
});

async function deleteUser(type, id) {
    if (!confirm('Tem certeza que deseja excluir este usuário?')) return;

    try {
        const response = await fetch(`http://localhost:8080/${type}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            const card = document.querySelector(`[data-id="${id}"]`);
            card.style.transform = 'translateX(100%)';
            card.style.opacity = '0';
            setTimeout(() => card.remove(), 300);
        }
    } catch (error) {
        console.error('Erro ao excluir usuário:', error);
        alert('Erro ao excluir usuário');
    }
}