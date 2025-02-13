document.addEventListener('DOMContentLoaded', async () => {
    const userList = document.getElementById('userList');

    try {
        const response = await fetch('http://localhost:8080/clientes');
        const clientes = await response.json();

        if (clientes.length === 0) {
            userList.innerHTML = '<p style="text-align: center; color: var(--label-color);">Nenhum usuário cadastrado</p>';
            return;
        }

        userList.innerHTML = clientes.map(cliente => `
            <div class="user-card" data-id="${cliente.id}">
                <h3>${cliente.nome}</h3>
                <p>CPF: ${cliente.documento.cpf}</p>
                <p>Email: ${cliente.contato.email}</p>
                <p>Telefone: ${cliente.contato.telefone}</p>
                <p>Endereço: ${cliente.endereco.rua}, ${cliente.endereco.numero} - ${cliente.endereco.cidade}/${cliente.endereco.estado}</p>
                <button onclick="deleteUser(${cliente.id})" class="delete-btn">
                    <span>Excluir</span>
                </button>
            </div>
        `).join('');
    } catch (error) {
        userList.innerHTML = '<p style="text-align: center; color: var(--error-color);">Erro ao carregar usuários</p>';
        console.error('Erro ao carregar usuários:', error);
    }
});

async function deleteUser(id) {
    if (!confirm('Tem certeza que deseja excluir este usuário?')) {
        return;
    }

    const card = document.querySelector(`[data-id="${id}"]`);
    if (!card) return;

    try {
        const response = await fetch(`http://localhost:8080/clientes/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            card.style.transform = 'translateX(100%)';
            card.style.opacity = '0';
            setTimeout(() => card.remove(), 300);
        }
    } catch (error) {
        console.error('Erro ao excluir usuário:', error);
        alert('Erro ao excluir usuário');
    }
}