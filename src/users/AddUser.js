import axios from 'axios'
import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'

export default function AddUser() {

        let navigate= useNavigate()
    const[user,setUsers]=useState({
        name:"",
        username:"",
        email:""
    })

    const{name,username,email}=user

    const onInputChange=(e)=>{
        setUsers({...user,[e.target.name]:e.target.value})
    }
    const onSubmit=async (e)=>{
        e.preventDefault();
        await axios.post("http://localhost:8080/user",user)
        navigate("/")
    }
  return (
    <div className='container '>
        <div className='row'>
            <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                <h2 className='text-center m-4'>新幹線を登録</h2>
                <form onSubmit={(e)=>onSubmit(e)}>
                <div className='mb-3'>
                    <label htmlFor='Name' className='form-label'>
                        新幹線ID
                    </label>
                    <input
                    type={"text"}
                    className='form-control'
                    placeholder='新幹線ID'
                    name='name'
                    value={name}
                    onChange={(e)=>onInputChange(e)}
                    /> 
                </div>

                <div className='mb-3'>
                    <label htmlFor='Username' className='form-label'>
                        オペレーター名
                    </label>
                    <input
                    type={"text"}
                    className='form-control'
                    placeholder='オペレーター名'
                    name='username'
                    value={username}
                    onChange={(e)=>onInputChange(e)}
                    /> 
                </div>

                <div className='mb-3'>
                    <label htmlFor='Email' className='form-label'>
                        経路
                    </label>
                    <input
                    type={"text"}
                    className='form-control'
                    placeholder='経路'
                    name='email'
                    value={email}
                    onChange={(e)=>onInputChange(e)}
                    /> 
                </div>
                <button type='submit' className='btn btn-outline-primary'>保存</button>
                <Link className='btn btn-outline-danger mx-2' to="/">戻る</Link>
                </form>
            </div>
        </div>
    </div>
  )
}
