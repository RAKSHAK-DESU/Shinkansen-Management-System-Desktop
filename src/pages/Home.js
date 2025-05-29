import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useParams } from 'react-router-dom';  

export default function Home() {
    const [users, setUsers] = useState([]);

    const { id } = useParams();

    useEffect(() => {
        loadUsers();
    }, []);

    const loadUsers = async () => {
        const result = await axios.get("http://localhost:8080/users");
        setUsers(result.data);
    };

    const deleteUser = async (id) => {
        await axios.delete(`http://localhost:8080/user/${id}`);
        loadUsers();
    };

    return (
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">番号</th>
                            <th scope="col">新幹線ID</th>
                            <th scope="col">オペレーター名</th>
                            <th scope="col">経路</th>
                            <th scope="col">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map((user, index) => (
                            <tr key={user.id}>
                                <th scope="row">{index + 1}</th>
                                <td>{user.name}</td>
                                <td>{user.username}</td>
                                <td>{user.email}</td>
                                <td>
                                    <Link className='btn btn-primary mx-2' to={`/viewuser/${user.id}`}>詳細</Link>
                                    <Link className='btn btn-outline-primary mx-2' to={`/edituser/${user.id}`}>編集</Link>
                                    <button
                                        className="btn btn-danger mx-2"
                                        onClick={() => deleteUser(user.id)}
                                    >
                                        削除
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
